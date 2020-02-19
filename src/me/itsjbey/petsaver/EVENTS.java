package me.itsjbey.petsaver;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

public class EVENTS implements Listener {
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		
		if(e.getEntity().getType() == EntityType.WOLF) {
			
			Wolf w = (Wolf) e.getEntity();
			
			if(w.isTamed()) {
				
				if(e.getDamage() > w.getHealth() || !w.hasAI()) {
					
					w.setHealth(1);
					e.setCancelled(true);
					w.setAI(false);
					
					((Player) w.getOwner()).sendMessage("§cYour Wolf died but you can still save it by feeding it.");
					
				}
					
			}
			
		}
		
	}
	
	@EventHandler
	public void onFeed(PlayerInteractAtEntityEvent e) {
		
		if(e.getRightClicked().getType() == EntityType.WOLF) {
			
			Wolf w = (Wolf) e.getRightClicked();
			
			if(w.isTamed() && w.getHealth() <= 1) {
				
				if(((Player) e.getPlayer()).getInventory().getItemInMainHand() != null && ((Player) e.getPlayer()).getInventory().getItemInMainHand().getType().isEdible()) {
					
					w.setAI(true);
					
				}
				
			}
			
		}
		
	}

}
