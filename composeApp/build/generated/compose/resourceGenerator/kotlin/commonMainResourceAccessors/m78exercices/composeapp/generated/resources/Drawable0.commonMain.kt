@file:OptIn(org.jetbrains.compose.resources.InternalResourceApi::class)

package m78exercices.composeapp.generated.resources

import kotlin.OptIn
import kotlin.String
import kotlin.collections.MutableMap
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.InternalResourceApi

private object CommonMainDrawable0 {
  public val generated: DrawableResource by 
      lazy { init_generated() }
}

@InternalResourceApi
internal fun _collectCommonMainDrawable0Resources(map: MutableMap<String, DrawableResource>) {
  map.put("generated", CommonMainDrawable0.generated)
}

internal val Res.drawable.generated: DrawableResource
  get() = CommonMainDrawable0.generated

private fun init_generated(): DrawableResource = org.jetbrains.compose.resources.DrawableResource(
  "drawable:generated",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/m78exercices.composeapp.generated.resources/drawable/generated.png", -1, -1),
    )
)
