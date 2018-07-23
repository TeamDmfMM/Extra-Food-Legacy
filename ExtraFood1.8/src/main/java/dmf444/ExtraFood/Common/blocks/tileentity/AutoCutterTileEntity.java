package dmf444.ExtraFood.Common.blocks.tileentity;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;
import dmf444.ExtraFood.ExtraFood;
import dmf444.ExtraFood.Client.renderer.AutoCutterModel;
import dmf444.ExtraFood.Client.renderer.AutoCutterRenderer;
import dmf444.ExtraFood.Common.items.ItemLoader;


public class AutoCutterTileEntity extends TileEntity implements ISidedInventory, IUpdatePlayerListBox {


    private ItemStack[] inv;
    private static final int[] slots_top = new int[] {0};
    private static final int[] slots_bottom = new int[] {2, 1};
    private static final int[] slots_sides = new int[] {1};


    public AutoCutterTileEntity(){
            inv = new ItemStack[3];
    }
    

    public int getSizeInventory() {
            return inv.length;
    }



    public ItemStack getStackInSlot(int slot) {
            return inv[slot];
    }
    

    public void setInventorySlotContents(int slot, ItemStack stack) {
            inv[slot] = stack;
            if (stack != null && stack.stackSize > getInventoryStackLimit()) {
                    stack.stackSize = getInventoryStackLimit();
            }               
    }



    public ItemStack decrStackSize(int slot, int amt) {
            ItemStack stack = getStackInSlot(slot);
            if (stack != null) {
                    if (stack.stackSize <= amt) {
                            setInventorySlotContents(slot, null);
                    } else {
                            stack = stack.splitStack(amt);
                            if (stack.stackSize == 0) {
                                    setInventorySlotContents(slot, null);
                            }
                    }
            }
            return stack;
    }


    public ItemStack getStackInSlotOnClosing(int slot) {
            ItemStack stack = getStackInSlot(slot);
            if (stack != null) {
                    setInventorySlotContents(slot, null);
            }
            return stack;
    }
    

    public int getInventoryStackLimit() {
            return 64;
    }



    public boolean isUseableByPlayer(EntityPlayer player) {
    	return worldObj.getTileEntity(new BlockPos(pos.getX(), pos.getY(), pos.getZ())) == this &&
                player.getDistanceSq(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ()+ 0.5) < 64;
    }


    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
            super.readFromNBT(tagCompound);
            
            NBTTagList tagList = tagCompound.getTagList("Inventory", 10);
            for (int i = 0; i < tagList.tagCount(); i++) {
                    NBTTagCompound tag = (NBTTagCompound) tagList.getCompoundTagAt(i);
                    byte slot = tag.getByte("Slot");
                    if (slot >= 0 && slot < inv.length) {
                            inv[slot] = ItemStack.loadItemStackFromNBT(tag);
                    }
            }
    }


    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
            super.writeToNBT(tagCompound);
                            
            NBTTagList itemList = new NBTTagList();
            for (int i = 0; i < inv.length; i++) {
                    ItemStack stack = inv[i];
                    if (stack != null) {
                            NBTTagCompound tag = new NBTTagCompound();
                            tag.setByte("Slot", (byte) i);
                            stack.writeToNBT(tag);
                            itemList.appendTag(tag);
                    }
            }
            tagCompound.setTag("Inventory", itemList);
    }
    


   public String getName() {
         return "extrafood.autocutter";
   }
   
            
            
            
	public boolean work;
	//TODO constructors
	public int complete;
	public int ttime;



	public boolean hasCustomName() {
		return false;
	}



	public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
		/*if (this.inv[slot] != null){
			if (ExtraFood.registryCutter.getItemOutput(this.inv[slot]) != null){
				return true;
			}
			return true;
		}
		return false;
		*/
       return slot == 2 ? false : (slot == 1 ? itemstack == new ItemStack(ItemLoader.cheeseWheel, 1) : true);
	}
		
	
	public boolean ok(){

		/*
		 * With seven checks, this function returns true if the autocutter is in an ok state to continue/start cutting!
		 */


		if (this.inv[0] != null){//1
			//System.out.println("1-out");					
			if (this.inv[2] != null){//2
				if(this.inv[2].getItem() == ItemLoader.knife){//3
					//System.out.println("2.5-out");		
					if (ExtraFood.registryCutter.getItemOutput(this.inv[0]) != null){//4
						//System.out.println("2-out");		
						ItemStack l = ExtraFood.registryCutter.getItemOutput(this.inv[0]);
						if (this.inv[1] != null){//5
							//System.out.println("3-in");
							if (this.inv[1].getItem() == l.getItem()){//6
								//System.out.println("4-donein");


								return true;//6}
							}
								else {
									return false;
								}
						}
						//System.out.println("3-doneout");
						return true;//3
					}
					//System.out.println("Why am I tracking4");
					return false;//2
				}
				//System.out.println("3");
				return false;//1
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	
	public void update(){

	if (this.ok()){
		//if (!this.worldObj.isRemote){
			this.ttime += 1;
			if (this.ttime == 20){
				this.ttime = 0;
				this.complete += 1;
				if (this.complete == 5){
					//System.out.println("ko");
					
					this.do_();
					this.complete = 0;
					this.ttime = 0;
					markDirty();
				}
			}
		}
	  //}
	}


	private void do_() {
		ItemStack l = ExtraFood.registryCutter.getItemOutput(this.inv[0]);
		if (this.inv[1] == null){
			//System.out.println("followin' 1");
			this.inv[1] = l.copy();
		}
		else if(this.inv[1].getItem() == l.getItem()) {
			//System.out.println("followin' 2");
			this.inv[1].stackSize += l.stackSize;
			//this.inv[1].stackSize += l.stackSize;
		}
		--this.inv[0].stackSize;
		//this.decrStackSize(0, 1);
		 if (this.inv[0].stackSize <= 0)
         {
             this.inv[0] = null;
         }
	}
	

	@Override
    public boolean canInsertItem(int slot, ItemStack item, EnumFacing direction)
    {
        return this.isItemValidForSlot(slot, item);
    }
    public boolean canExtractItem(int slot, ItemStack stack,EnumFacing direction)
    {
        return direction != EnumFacing.DOWN || slot != 2 || stack.getItem() == Items.bucket;
    }
    public int[] getSlotsForFace(EnumFacing side)
    {
        return side == EnumFacing.DOWN ? slots_bottom : (side == EnumFacing.UP ? slots_top : slots_sides);
    }


	@Override
	public void openInventory(EntityPlayer p) {}


	@Override
	public void closeInventory(EntityPlayer p) {}


	@Override
	public int getField(int id) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void setField(int id, int value) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int getFieldCount() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IChatComponent getDisplayName() {
		// TODO Auto-generated method stub
		return null;
	}

}
