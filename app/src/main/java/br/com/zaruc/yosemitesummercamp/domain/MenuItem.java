package br.com.zaruc.yosemitesummercamp.domain;

public class MenuItem {
    String label;
    Integer icon;
    MenuItemStatus isSelected = MenuItemStatus.NOT_SELECTED;

    public MenuItem(String label, Integer icon) {
        this.label = label;
        this.icon = icon;
    }

    public String getLabel() {
        return label;
    }

    public Integer getIcon() {
        return icon;
    }

    public MenuItemStatus getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(MenuItemStatus isSelected) {
        this.isSelected = isSelected;
    }
}
