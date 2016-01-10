package com.datinko.eir.state


/**
  * Models the state of a sporting event (primarily the money staked on it!).
  * (Is this event handlers?)
  */
case class MatchState(totalStake: Float) {

  //These are not event handlers - these are calls to methods on our state objects - these method are what the
  //event handlers call to change the in-memory domain.
  def updated(newStake: Float): MatchState = {
    val newTotal = totalStake + newStake
    println(s"Updating State because of new stake $newStake - totalStake is now $newTotal")
    MatchState(newTotal)
  }
}


