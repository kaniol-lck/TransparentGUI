package net.kaniol.mixin;

import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.gui.widget.ClickableWidget;
import com.mojang.blaze3d.systems.RenderSystem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClickableWidget.class)
public class ClickableWidgetMixin {
	@Inject(at = @At("HEAD"), method = "render")
	public void renderHead(MatrixStack matrices, int mouseX, int mouseY, float delta, CallbackInfo ci) {
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
	}

	@Inject(at = @At("TAIL"), method = "render")
	public void renderTail(MatrixStack matrices, int mouseX, int mouseY, float delta, CallbackInfo ci) {
		RenderSystem.disableBlend();
	}
}
