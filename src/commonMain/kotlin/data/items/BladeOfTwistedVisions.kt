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
public class BladeOfTwistedVisions : Item() {
  public override var isAutoGenerated: Boolean = true

  public override var id: Int = 33467

  public override var name: String = "Blade of Twisted Visions"

  public override var itemLevel: Int = 138

  public override var quality: Int = 4

  public override var icon: String = "inv_sword_109.jpg"

  public override var inventorySlot: Int = 21

  public override var itemSet: ItemSet? = null

  public override var itemClass: Constants.ItemClass? = Constants.ItemClass.WEAPON

  public override var itemSubclass: Constants.ItemSubclass? = Constants.ItemSubclass.SWORD_1H

  public override var allowableClasses: Array<Constants.AllowableClass>? = null

  public override var minDmg: Double = 20.860000610351562

  public override var maxDmg: Double = 127.86000061035156

  public override var speed: Double = 1800.0

  public override var stats: Stats = Stats(
      stamina = 33,
      intellect = 21,
      spellHasteRating = 21.0
      )

  public override var sockets: Array<Socket> = arrayOf()

  public override var socketBonus: SocketBonus? = null

  public override val buffs: List<Buff> by lazy {
        listOfNotNull(
        Buffs.byIdOrName(42814, "Increase Spell Dam 229", this)
        )}

}
