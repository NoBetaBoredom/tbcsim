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
public class LionheartExecutioner : Item() {
  public override var isAutoGenerated: Boolean = true

  public override var id: Int = 28430

  public override var name: String = "Lionheart Executioner"

  public override var itemLevel: Int = 136

  public override var quality: Int = 4

  public override var icon: String = "inv_sword_2h_blacksmithing_03.jpg"

  public override var inventorySlot: Int = 17

  public override var itemSet: ItemSet? = null

  public override var itemClass: Constants.ItemClass? = Constants.ItemClass.WEAPON

  public override var itemSubclass: Constants.ItemSubclass? = Constants.ItemSubclass.SWORD_2H

  public override var allowableClasses: Array<Constants.AllowableClass>? = null

  public override var minDmg: Double = 365.0

  public override var maxDmg: Double = 549.0

  public override var speed: Double = 3600.0

  public override var stats: Stats = Stats(
      strength = 52,
      agility = 44
      )

  public override var sockets: Array<Socket> = arrayOf()

  public override var socketBonus: SocketBonus? = null

  public override val buffs: List<Buff> by lazy {
        listOfNotNull(
        Buffs.byIdOrName(34515, "Fear Resistance 8", this),
        Buffs.byIdOrName(34513, "Lionheart", this)
        )}

}
