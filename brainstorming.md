 - The `Train` class will have a relationship with the `Engine` class, because the `Engine` is responsible for powering the `Train`.
 - The `Train` class also has a relationship with the `Car` class: the `Train` has a collection of `Cars` associated with it at any given time, and you can add / remove `Cars` as necessary (without destroying either the `Train` or the `Cars` themselves).
 - The `Passenger` class has relationships with both the `Car` and `Train` classes (`Passenger`s board `Car`s as their means of using the `Train` to move around more efficiently).

  - Does **another class** need to be able to **read** this value? (If so, it could either be marked `public` or have an `accessor`)
 - Does **another class** need to be able to **modify** this value? (If so, it could either be marked `public` or have a `manipulator`)

 Train will need to be able to read fueltype, read maxfuel, and current fuel

 
