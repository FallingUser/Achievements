#Commands for options:
execute unless data storage achievements:options use_old_criteria run data modify storage achievements:options use_old_criteria set value true
execute unless data storage achievements:options what_criteria_do_acquire_iron_use run data modify storage achievements:options what_criteria_do_acquire_iron_use set value "use_new_criteria"

#Commands for When Pigs Fly:
scoreboard objectives add fallDistance dummy

#Commands for On A Rail:
scoreboard objectives add MoveDistanceByMinecart minecraft.custom:minecraft.minecart_one_cm

#Commands for Diamonds to you:
function achievements:starter_of_diamonds_to_you