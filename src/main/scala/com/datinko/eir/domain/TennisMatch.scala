package com.datinko.eir.domain

import akka.persistence.PersistentActor
import com.datinko.eir.commands.{PrintTotalStake, TotalStakeIs, VoidBet, PlaceBet}
import com.datinko.eir.events.{Evt, TotalStakeChangedBy}
import com.datinko.eir.state.MatchState
import com.typesafe.scalalogging.LazyLogging

class TennisMatch extends PersistentActor with LazyLogging {

  var state = MatchState(totalStake = 0f)

  //events are handled here...
  def updateState(event: Evt): Unit = event match {
    case TotalStakeChangedBy(stake) => {
      logger.debug(s"Handling 'TotalStakeChangedBy($stake)' Event...")
      state = state.updated(stake)
    }
    case _ => logger.debug("Unknown Event")
  }


  //CQRS API :  Command Handlers - they determine which events to raise in response to the command, persist the events and then
  //modify the internal application state.  Events are then broadcast to the outside world if needed.
  override def receiveCommand = {

    //Command Handlers are defined here, they fire events

    case PlaceBet(stake) =>
      logger.debug(s"Received 'PlaceBet($stake)' Command...")
      logger.debug(s"Persisting 'TotalStakeChangedBy($stake)' Event...")
      persist(TotalStakeChangedBy(stake)) { changed =>
        logger.debug(s"Updating State...")
        updateState(changed)
        //context.system.eventStream.publish(changed)
      }

    case VoidBet(stake) if stake <= state.totalStake =>
      persist(TotalStakeChangedBy(-stake)) { changed =>
        //akka ensures its safe to mutate the state
        updateState(changed)
        //we are guaranteed to have the right sender here - unlike normal actor model
        //(not sure about sending a command back tho?! - thought CQRS says it should be an event?)
        sender() ! TotalStakeIs(state.totalStake)
      }
    case PrintTotalStake() => logger.debug("Got asked to Print Total Stake")
    case _ => logger.debug("UNKNOWN COMMAND")
  }


  override def receiveRecover = {

    case replayedEvent: Evt =>
      updateState(replayedEvent)
  }


  override def persistenceId = "tennismatch-actor-id-1"


}
