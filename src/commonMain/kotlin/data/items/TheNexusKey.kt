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
public class TheNexusKey : Item() {
  public override var isAutoGenerated: Boolean = true

  public override var id: Int = 29988

  public override var name: String = "The Nexus Key"

  public override var itemLevel: Int = 141

  public override var quality: Int = 4

  public override var icon: String = "inv_staff_43.jpg"

  public override var inventorySlot: Int = 17

  public override var itemSet: ItemSet? = null

  public override var itemClass: Constants.ItemClass? = Constants.ItemClass.WEAPON

  public override var itemSubclass: Constants.ItemSubclass? = Constants.ItemSubclass.STAFF

  public override var allowableClasses: Array<Constants.AllowableClass>? = null

  public override var minDmg: Double = 145.1999969482422

  public override var maxDmg: Double = 312.20001220703125

  public override var speed: Double = 3200.0

  public override var stats: Stats = Stats(
      stamina = 76,
      intellect = 52,
      spellCritRating = 51.0
      )

  public override var sockets: Array<Socket> = arrayOf()

  public override var socketBonus: SocketBonus? = null

  public override val buffs: List<Buff> by lazy {
        listOfNotNull(
        Buffs.byIdOrName(44072, "Increase Spell Dam 236", this)
        )}

}
