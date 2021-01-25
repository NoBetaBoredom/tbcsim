package `data`.items

import `data`.Constants
import `data`.buffs.Buffs
import `data`.model.Item
import `data`.model.ItemSet
import `data`.model.Socket
import `data`.model.SocketBonus
import character.Buff
import character.Stats
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.collections.List

public class Stormherald : Item() {
  public override var isAutoGenerated: Boolean = true

  public override var name: String = "Stormherald"

  public override var itemLevel: Int = 136

  public override var itemSet: ItemSet? = null

  public override var itemClass: Constants.ItemClass? = Constants.ItemClass.WEAPON

  public override var itemSubclass: Constants.ItemSubclass? = Constants.ItemSubclass.MACE_2H

  public override var minDmg: Double = 386.0

  public override var maxDmg: Double = 579.0

  public override var speed: Double = 3800.0

  public override var stats: Stats = Stats(
      strength = 42,
      agility = 42,
      stamina = 61
      )

  public override var sockets: List<Socket> = listOf()

  public override var socketBonus: SocketBonus? = null

  public override var buffs: List<Buff> = listOfNotNull(
      Buffs.byId(34510)
      )
}