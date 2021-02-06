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

public class GreatEarthforgedHammer : Item() {
  public override var isAutoGenerated: Boolean = true

  public override var id: Int = 30093

  public override var name: String = "Great Earthforged Hammer"

  public override var itemLevel: Int = 100

  public override var itemSet: ItemSet? = null

  public override var itemClass: Constants.ItemClass? = Constants.ItemClass.WEAPON

  public override var itemSubclass: Constants.ItemSubclass? = Constants.ItemSubclass.MACE_2H

  public override var minDmg: Double = 220.0

  public override var maxDmg: Double = 330.0

  public override var speed: Double = 3500.0

  public override var stats: Stats = Stats(
      stamina = 60
      )

  public override var sockets: List<Socket> = listOf()

  public override var socketBonus: SocketBonus? = null

  public override var buffs: List<Buff> = listOfNotNull(
      Buffs.byIdOrName(15820, "Attack Power 70", this)
      )
}