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
public class AuchenaiStaff : Item() {
  public override var isAutoGenerated: Boolean = true

  public override var id: Int = 29130

  public override var name: String = "Auchenai Staff"

  public override var itemLevel: Int = 115

  public override var quality: Int = 3

  public override var icon: String = "inv_staff_14.jpg"

  public override var inventorySlot: Int = 17

  public override var itemSet: ItemSet? = null

  public override var itemClass: Constants.ItemClass? = Constants.ItemClass.WEAPON

  public override var itemSubclass: Constants.ItemSubclass? = Constants.ItemSubclass.STAFF

  public override var allowableClasses: Array<Constants.AllowableClass>? = null

  public override var minDmg: Double = 92.37000274658203

  public override var maxDmg: Double = 171.3699951171875

  public override var speed: Double = 2100.0

  public override var stats: Stats = Stats(
      intellect = 46,
      spellCritRating = 26.0,
      spellHitRating = 19.0
      )

  public override var sockets: Array<Socket> = arrayOf()

  public override var socketBonus: SocketBonus? = null

  public override val buffs: List<Buff> by lazy {
        listOfNotNull(
        Buffs.byIdOrName(33250, "Increase Spell Dam 121", this)
        )}

}
