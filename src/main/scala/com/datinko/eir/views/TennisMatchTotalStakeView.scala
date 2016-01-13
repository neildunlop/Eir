package com.datinko.eir.views

import akka.persistence.PersistentView
import com.datinko.eir.commands.PrintTotalStake
import com.datinko.eir.events.TotalStakeChangedBy
import com.typesafe.scalalogging.LazyLogging

/**
  * A simple persistent view that records the total stake of a tennis match over time.
  * (Remember, without this there is not way for external systems to know the totalstake on our event!)
  */
class TennisMatchTotalStakeView extends PersistentView with LazyLogging {

  override val viewId: String = s"tennismatch-totalstake-view-${self.path.name}"
  //override val persistenceId: String = s"user-exercises-${self.path.name}"
  override val persistenceId: String = "tennismatch-actor-id-1"

  var totalStake: Float = 0f

  override def receive = {
    case TotalStakeChangedBy(stake) => {
      logger.debug("VIEW HANDLING TOTALSTAKECHANGEDBY EVENT")
      totalStake = totalStake+stake
    }  //this is an Event
    case PrintTotalStake() => {
      logger.debug(s"TennisMatchTotalStakeView says total stake is: $totalStake")
      println(s"TennisMatchTotalStakeView says total stake is: $totalStake")
    } //but this is a Command??
    case _ => logger.debug("Unknown Message")


  }
}
