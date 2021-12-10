import BaseItem from "../items/BaseItem";
import EvolveeEnvironment from "../EvolveeEnvironment";
import { ItemType } from "../imagers/furniture/FurniImager";

export default class UserItem {
    id: number;
    baseItem: BaseItem | null;
    baseId: number;
    state: number;
    stackable: boolean;
    itemType: ItemType;

    constructor(id: number, baseId: number, state: number, stackable: boolean, itemType: ItemType) {
        this.id = id;
        this.baseId = baseId;
        this.state = state;
        this.stackable = stackable;
        this.itemType = itemType;
        this.baseItem = null;
    }

    loadBase(): Promise<void> {
        return EvolveeEnvironment.getGame().baseItemManager.getItem(this.itemType, this.baseId).then(baseItem => {
            this.baseItem = baseItem;
        });
    }
}