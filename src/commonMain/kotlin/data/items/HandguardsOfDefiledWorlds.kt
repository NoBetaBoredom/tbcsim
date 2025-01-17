package `data`.items

import `data`.Constants
import `data`.buffs.Buffs
import `data`.model.Color
import `data`.model.Item
import `data`.model.ItemSet
import `data`.model.Socket
import `data`.model.SocketBonus
import `data`.socketbonus.SocketBonuses
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
public class HandguardsOfDefiledWorlds : Item() {
  public override var isAutoGenerated: Boolean = true

  public override var id: Int = 34344

  public override var name: String = "Handguards of Defiled Worlds"

  public override var itemLevel: Int = 164

  public override var quality: Int = 4

  public override var icon: String = "inv_gauntlets_15.jpg"

  public override var inventorySlot: Int = 10

  public override var itemSet: ItemSet? = null

  public override var itemClass: Constants.ItemClass? = Constants.ItemClass.ARMOR

  public override var itemSubclass: Constants.ItemSubclass? = Constants.ItemSubclass.CLOTH

  public override var allowableClasses: Array<Constants.AllowableClass>? = null

  public override var minDmg: Double = 0.0

  public override var maxDmg: Double = 0.0

  public override var speed: Double = 0.0

  public override var stats: Stats = Stats(
      stamina = 33,
      intellect = 32,
      armor = 171,
      spellHitRating = 27.0,
      spellHasteRating = 36.0
      )

  public override var sockets: Array<Socket> = arrayOf(
      Socket(Color.YELLOW),
      Socket(Color.RED)
      )

  public override var socketBonus: SocketBonus? = SocketBonuses.byId(2900)

  public override val buffs: List<Buff> by lazy {
        listOfNotNull(
        Buffs.byIdOrName(24196, "Increase Spell Dam 47", this)
        )}

}
