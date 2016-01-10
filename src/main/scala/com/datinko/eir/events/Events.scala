package com.datinko.eir.events

//Events get persisted
sealed trait Evt
case class TotalStakeChangedBy(stake: Float) extends Evt

