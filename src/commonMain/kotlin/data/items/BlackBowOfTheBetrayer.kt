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
public class BlackBowOfTheBetrayer : Item() {
  public override var isAutoGenerated: Boolean = true

  public override var id: Int = 32336

  public override var name: String = "Black Bow of the Betrayer"

  public override var itemLevel: Int = 151

  public override var quality: Int = 4

  public override var icon: String = "inv_weapon_bow_31.jpg"

  public override var inventorySlot: Int = 15

  public override var itemSet: ItemSet? = null

  public override var itemClass: Constants.ItemClass? = Constants.ItemClass.WEAPON

  public override var itemSubclass: Constants.ItemSubclass? = Constants.ItemSubclass.BOW

  public override var minDmg: Double = 201.0

  public override var maxDmg: Double = 374.0

  public override var speed: Double = 3000.0

  public override var stats: Stats = Stats(

      )

  public override var sockets: Array<Socket> = arrayOf()

  public override var socketBonus: SocketBonus? = null

  public override val buffs: List<Buff> by lazy {
        listOfNotNull(
        Buffs.byIdOrName(46939, "Black Bow of the Betrayer", this),
        Buffs.byIdOrName(9334, "Attack Power 26", this)
        )}

}