# kdbush

Java KD-Bush implementation 

Based on [this](https://github.com/mourner/kdbush) JavaScript implementation by [Vladimir Agafonkin](http://agafonkin.com/)
and on [this](https://github.com/marchello2000/kdbush) C# implementation by marchello2000

KD-Bush is a very fast static spatial index for 2D points based on a flat KD-tree.  
Compared to RBush:

* points only — no rectangles
* static — you can't add/remove items
* indexing is 5-8 times faster

## Usage
```java
Double[][] pointsData =  new Double[][] {
                new Double[]{24.0, 35.0}, 
                new Double[]{37.0, 41.0},
                new Double[]{65.0, 35.0}
                };
KDBush index = new KDBush<Double[]>(pointsData);

// Get all points that lie inside the rectangle 
// (20, 30)-(50, 70)
List<Integer> ids1 = index.range(20, 30, 50, 70); 

// Get all points that lie inside the circle 
// centered at (50, 50) with radius 20
List<Integer> ids2 = index.within(20, 30, 50); 
```
