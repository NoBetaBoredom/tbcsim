package `data`.items

import `data`.Constants
import `data`.buffs.Buffs
import `data`.model.Item
import `data`.model.ItemSet
import `data`.model.Socket
import `data`.model.SocketBonus
import character.Buff
import character.Stats
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.js.JsExport

@JsExport
public class HardenedStoneShard : Item() {
  public override var isAutoGenerated: Boolean = true

  public override var id: Int = 29150

  public override var name: String = "Hardened Stone Shard"

  public override var itemLevel: Int = 91

  public override var quality: Int = 3

  public override var icon: String = "inv_weapon_shortblade_08.jpg"

  public override var inventorySlot: Int = 13

  public override var itemSet: ItemSet? = null

  public override var itemClass: Constants.ItemClass? = Constants.ItemClass.WEAPON

  public override var itemSubclass: Constants.ItemSubclass? = Constants.ItemSubclass.DAGGER

  public override var allowableClasses: Array<Constants.AllowableClass>? = null

  public override var minDmg: Double = 79.0

  public override var maxDmg: Double = 120.0

  public override var speed: Double = 1800.0

  public override var stats: Stats = Stats(
      stamina = 16,
      physicalHitRating = 12.0
      )

  public override var sockets: Array<Socket> = arrayOf()

  public override var socketBonus: SocketBonus? = null

  public override val buffs: List<Buff> by lazy {
        listOfNotNull(
        Buffs.byIdOrName(9332, "Attack Power 22", this)
        )}

}
