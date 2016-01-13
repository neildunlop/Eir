package com.datinko.eir.commands

//Commands do NOT get persisted
sealed trait Command
case class PlaceBet(stake: Float) extends Command
case class VoidBet(stake: Float) extends Command
case class TotalStakeIs(stake: Float) extends Command
case class PrintTotalStake() extends Command

case class ActivateMatch() extends Command
case class SuspendMatch() extends Command
case class CloseMatch() extends Command
