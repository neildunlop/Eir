package com.datinko.eir

import akka.actor.{Props, ActorSystem}
import com.datinko.eir.commands.{PrintTotalStake, VoidBet, PlaceBet}
import com.datinko.eir.domain.TennisMatch
import com.datinko.eir.views.TennisMatchTotalStakeView

/**
  * Created by Neil on 10/01/2016.
  */
object Start extends App {

  implicit val system = ActorSystem("eir")

  val tennisMatch = system.actorOf(Props[TennisMatch])
  val tennisMatchTotalStakeView = system.actorOf(Props[TennisMatchTotalStakeView])

  tennisMatch ! PlaceBet(21f)
  tennisMatch ! PlaceBet(10f)
  tennisMatch ! VoidBet(5f)

  tennisMatch ! PrintTotalStake()

  tennisMatchTotalStakeView ! PrintTotalStake()


  //Note: If you run this sample a few times you will see the 'Handling 'TotalStakeChangedBy(21.0)' Event...' appear
  //a few times - this is the journaling process running to recover the state of the actors before applying new commands.
  //This is of course, expected behaviour!


}
