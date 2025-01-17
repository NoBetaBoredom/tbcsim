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
public class LuminescentRodOfTheNaaru : Item() {
  public override var isAutoGenerated: Boolean = true

  public override var id: Int = 30080

  public override var name: String = "Luminescent Rod of the Naaru"

  public override var itemLevel: Int = 134

  public override var quality: Int = 4

  public override var icon: String = "inv_wand_15.jpg"

  public override var inventorySlot: Int = 26

  public override var itemSet: ItemSet? = null

  public override var itemClass: Constants.ItemClass? = Constants.ItemClass.WEAPON

  public override var itemSubclass: Constants.ItemSubclass? = Constants.ItemSubclass.WAND

  public override var allowableClasses: Array<Constants.AllowableClass>? = null

  public override var minDmg: Double = 186.0

  public override var maxDmg: Double = 346.0

  public override var speed: Double = 1500.0

  public override var stats: Stats = Stats(
      intellect = 14
      )

  public override var sockets: Array<Socket> = arrayOf()

  public override var socketBonus: SocketBonus? = null

  public override val buffs: List<Buff> by lazy {
        listOfNotNull(
        Buffs.byIdOrName(18029, "Increase Healing 35", this),
        Buffs.byIdOrName(21626, "Increased Mana Regen", this)
        )}

}
