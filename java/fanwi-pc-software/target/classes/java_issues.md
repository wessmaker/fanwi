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
tat