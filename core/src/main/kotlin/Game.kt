import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Graphics
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import glm_.vec2.Vec2
import imgui.ImGui
import imgui.functionalProgramming
import imgui.impl.LwjglGL3
import uno.glfw.GlfwWindow

/** [com.badlogic.gdx.ApplicationListener] implementation shared by all platforms.  */
class Game : ApplicationAdapter() {
    val context = imgui.Context()

    lateinit var spritesheet: TextureAtlas

    override fun create() {
        super.create()
        LwjglGL3.init(GlfwWindow((Gdx.graphics as Lwjgl3Graphics).window.windowHandle), false)

        spritesheet = TextureAtlas(Gdx.files.local("assets/medieval.atlas"))

        ImGui.styleColorsDark()
    }

    override fun render() {
        super.render()
        Gdx.gl.glClearColor(0f,0f,0f,1f )
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT or GL20.GL_DEPTH_BUFFER_BIT)

        LwjglGL3.newFrame()

        functionalProgramming.withWindow("Test") {
            spritesheet.regions.forEachIndexed { index, it ->
                if(ImGui.imageButton(it.texture.textureObjectHandle, Vec2(50f), Vec2(it.u, it.v), Vec2(it.u2, it.v2))) {
                    println("Click ! index : $index")
                }
            }
        }

        ImGui.render()

        if(ImGui.drawData != null)
            LwjglGL3.renderDrawData(ImGui.drawData!!)
    }

    override fun dispose() {
        super.dispose()
        spritesheet.dispose()
    }
}