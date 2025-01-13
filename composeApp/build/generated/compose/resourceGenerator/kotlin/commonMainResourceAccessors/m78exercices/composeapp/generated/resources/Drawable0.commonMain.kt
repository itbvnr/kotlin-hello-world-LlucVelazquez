@file:OptIn(org.jetbrains.compose.resources.InternalResourceApi::class)

package m78exercices.composeapp.generated.resources

import kotlin.OptIn
import kotlin.String
import kotlin.collections.MutableMap
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.InternalResourceApi

private object CommonMainDrawable0 {
  public val generatedFace: DrawableResource by 
      lazy { init_generatedFace() }
}

@InternalResourceApi
internal fun _collectCommonMainDrawable0Resources(map: MutableMap<String, DrawableResource>) {
  map.put("generatedFace", CommonMainDrawable0.generatedFace)
}

internal val Res.drawable.generatedFace: DrawableResource
  get() = CommonMainDrawable0.generatedFace

private fun init_generatedFace(): DrawableResource =
    org.jetbrains.compose.resources.DrawableResource(
  "drawable:generatedFace",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/m78exercices.composeapp.generated.resources/drawable/generatedFace.png", -1, -1),
    )
)
