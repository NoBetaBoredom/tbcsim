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

public class ApostleOfArgus : Item() {
  public override var isAutoGenerated: Boolean = true

  public override var name: String = "Apostle of Argus"

  public override var itemLevel: Int = 151

  public override var itemSet: ItemSet? = null

  public override var itemClass: Constants.ItemClass? = Constants.ItemClass.WEAPON

  public override var itemSubclass: Constants.ItemSubclass? = Constants.ItemSubclass.STAFF

  public override var minDmg: Double = 145.63999938964844

  public override var maxDmg: Double = 322.6400146484375

  public override var speed: Double = 3200.0

  public override var stats: Stats = Stats(
      stamina = 62,
      intellect = 59
      )

  public override var sockets: List<Socket> = listOf()

  public override var socketBonus: SocketBonus? = null

  public override var buffs: List<Buff> = listOfNotNull(
      Buffs.byId(42059),
      Buffs.byId(42060)
      )
}