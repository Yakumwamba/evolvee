import { ItemType } from "../imagers/furniture/FurniImager";
import EvolveeEnvironment from "../EvolveeEnvironment";
import BaseItem from "../items/BaseItem";

export default class CatalogueItem {
    itemId: number;
    itemName: string;
    cost: number;
    itemType: ItemType;
    baseId: number;
    baseItem: BaseItem | null;
    amount: number;

    constructor(itemId: number, itemName: string, cost: number, itemType: ItemType, baseId: number, amount: number) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.cost = cost;
        this.itemType = itemType;
        this.baseId = baseId;
        this.amount = amount;
        this.baseItem = null;
    }

    loadBase(): Promise<BaseItem> {
        return EvolveeEnvironment.getGame().baseItemManager.getItem(this.itemType, this.baseId).then(baseItem => {
            this.baseItem = baseItem;
            return baseItem;
        });
    }
}