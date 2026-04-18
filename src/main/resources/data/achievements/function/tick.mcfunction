#Commands for When Pigs Fly:
execute as @a[nbt={RootVehicle:{Entity:{id:"minecraft:pig"}}}] store result score @s fallDistance run data get entity @s RootVehicle.Entity.fall_distance
advancement grant @a[scores={fallDistance=5..}] only achievements:old_achievements_of_java_edition/fly_pig
scoreboard players set @a[nbt=!{RootVehicle:{Entity:{id:"minecraft:pig"}}}] fallDistance 0

#Commands for On A Rail:
scoreboard players set @a[nbt=!{RootVehicle:{Entity:{id:"minecraft:minecart"}}}] MoveDistanceByMinecart 0
advancement grant @a[scores={MoveDistanceByMinecart=100000..}] only achievements:old_achievements_of_java_edition/on_a_rail

#Commands for Diamonds To You!:
execute as @e[nbt={Item:{id:"minecraft:diamond"}}] run data modify entity @s Item.components."minecraft:custom_data".Thrower set from entity @s Thrower

#Commands for Acquire Iron:
execute if data storage achievements:options {what_criteria_do_acquire_iron_use:"use_new_criteria"} run function achievements:options/use_new_criteria_for_acquire_iron
execute if data storage achievements:options {what_criteria_do_acquire_iron_use:"use_old_criteria"} run function achievements:options/use_old_criteria_for_acquire_iron
execute if data storage achievements:options {what_criteria_do_acquire_iron_use:"use_wide_criteria"} run function achievements:options/use_wide_criteria_for_acquire_iron

#Commands for options:
execute if data storage achievements:options {use_old_criteria:true} run function achievements:options/use_old_criteria
execute if data storage achievements:options {use_old_criteria:false} run function achievements:options/use_new_criteria
