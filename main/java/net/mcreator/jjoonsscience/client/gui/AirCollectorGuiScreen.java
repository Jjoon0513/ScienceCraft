package net.mcreator.jjoonsscience.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;

import net.mcreator.jjoonsscience.world.inventory.AirCollectorGuiMenu;
import net.mcreator.jjoonsscience.procedures.GetGuiBubbleShowProcedure;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class AirCollectorGuiScreen extends AbstractContainerScreen<AirCollectorGuiMenu> {
	private final static HashMap<String, Object> guistate = AirCollectorGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public AirCollectorGuiScreen(AirCollectorGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 180;
		this.imageHeight = 180;
	}

	private static final ResourceLocation texture = new ResourceLocation("jjoons_science:textures/screens/air_collector_gui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		RenderSystem.setShaderTexture(0, new ResourceLocation("jjoons_science:textures/screens/arrow.png"));
		this.blit(ms, this.leftPos + 80, this.topPos + 44, 0, 0, 22, 15, 22, 15);

		RenderSystem.setShaderTexture(0, new ResourceLocation("jjoons_science:textures/screens/bubble.png"));
		this.blit(ms, this.leftPos + 80, this.topPos + 35, 0, 0, 16, 16, 16, 16);

		if (GetGuiBubbleShowProcedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("jjoons_science:textures/screens/bubble1.png"));
			this.blit(ms, this.leftPos + 80, this.topPos + 36, 0, 0, 16, 16, 16, 16);
		}
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, Component.translatable("gui.jjoons_science.air_collector_gui.label_empty"), 8, 7, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
	}
}
