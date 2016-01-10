package com.datinko.eir.commands

//Commands do NOT get persisted
sealed trait Command
case class PlaceBet(stake: Float) extends Command
case class VoidBet(stake: Float) extends Command
case class TotalStakeIs(stake: Float) extends Command

case class ActivateEvent() extends Command
case class SuspendEvent() extends Command
case class CloseEvent() extends Command
