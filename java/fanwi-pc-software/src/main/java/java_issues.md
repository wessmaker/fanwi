# Java directory issues

	
### ISSUE 

```
The type Stage from module javafx.graphics may not be accessible to clients due to missing 'requires transitive'Java(8390067)
```
### FIX 
add a line:
```
requires transitive javafx.graphics;
```
to [module-info.java](module-info.java)

---
### Cannot set root background color with CSS
Cannot change background color for gridpane in .css stylesheet that is going to be loaded to another scene

### FIX
1. Set colors under `.root`
2. Set background of the root node like normal node `#nodename`
3. In preview-window in scenebuilder background color cannot be seen but it works in program

#### Stylesheet:

```css
.root{
    /*Colors*/
    leftPanelBg: #101427;
    textBlue : #999dcc;
    menuBarBgColor : #191f3d;
    contentBgColor : #252842;   
    buttonColor : #191f3d;
    buttonHoverColor : #252e5a; 
}

#fanGridPane{   /*Root node*/
    -fx-background-color : leftPanelBg;  
}
```