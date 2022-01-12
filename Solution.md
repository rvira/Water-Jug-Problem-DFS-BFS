## Task environment:
- **Performance measure**: The target jug(4-gallon) is filled with the given amount (2 gallon) or not
- **Environment of Agent**: The two jugs (4-gallon and 2-gallon jug) and water level in each jug are the environment of agent.
- **Actuators**: The actions that can be taken according to the production rules are the actuators.
- **Sensors**: The program which maintains the water level in each jug (state) are the sensors.


## Production Rules: 
*(specific to case 3 gallon and 4 gallon jug water)*
- (x,y / x<4) -> (4,y)-------Fill the 4-gallon jug.
- (x,y / y<3) -> (x,3)------Fill the 3-gallon jug
- (x,y / x>0) -> (x-d,y)-----Pour some water out of the 4-gallon jug 
- (x,y / y>0) -> (x,y-d)------Pour some water out of the 3-gallon jug 
- (x,y / y>0) -> (x,0)------Empty the 3-gallon jug on ground. 
- (x,y / x+y>=4 ^ y>0) -> (4,y-(4-x)) ------our water from 3-gallon jug to the 4-gallon jug until the 4-gallon jug is full. 
- (x,y | x+y>=3 ^ x>0) -> (x-(3-y),3) ------ Pour water from 4-gallon jug into 3-gallon jug until 3-gallon jug is full.
- (x,y | x+y<=4 ^ y>0) -> (x+y,0) ------ Pour all water from 3-gallon jug into 4-gallon jug.
- (x,y | x+y <=3 ^ x>0) -> (0,x+y) ------ Pour all water from 4-gallon jug into 3-gallon jug.
- (0,2) -> (2,0) ------ Pour 2 gallon water from 3 gallon jug into 4 gallon jug.


## Partial State Space diagram:
<p align = "center">
<img src = "http://2.bp.blogspot.com/-gGmilFsnk2I/U8UGdIbLKjI/AAAAAAAAAfA/Pw3MuLbDA9E/s1600/1.png" alt = "state space diagram")
</p>
