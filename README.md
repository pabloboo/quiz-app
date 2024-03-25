# quiz-app
Kotlin freecodecamp course on building a quiz application

Course:
https://www.youtube.com/watch?v=kNghEbknLs8&ab_channel=freeCodeCamp.org

# List, Set, Map

Collections: group of objects in a single variable.

Mutable: you can write to that collection. You can add and remove elements from that collection.

Inmutable: you can only add elements when you instantiate the collection.

```kotlin
val names = ListOf<String>("Name 1", "Name 2", "Name 3") //inmutable list
println(names[0])

val names = mutableListOf("Name 1", "Name 2", "Name 3") //mutable list
names.add("Name 4")
names.removeAt(0)
names.removeAt("Name 2")
names.forEach { println(it) }
```

Set: collection which can only store unique elements, it cannot have duplicates.

```kotlin
val names = mutableSetOf<String>("Name 1", "Name 2", "Name 1") //mutable set
names.add("Name 3")
names.forEach { println(it) }
```

Map collection is used to store key-value pairs.

```kotlin
val users = mapOf<Int, String>(1 to "Name 1", 2 to "Name 2", 3 to "Name 3") //inmutable map
println(users[1])

val users = mutableMapOf<Int, String>(1 to "Name 1", 2 to "Name 2", 3 to "Name 3") //mutable map
users[5] = "Name 5"
user.remove(2)
users.forEach { t, u -> println("$t and $u") }
```

# Collections operations

Transformations: functions with you can change an specific collection.

```kotlin
val numbers = setOf(1,2,3,4)
println(numbers.map{it*10}) //multiply every item by 10

val numbersMap = mapOf("key 1" to 1, "key 2" to 2, "key 3" to 3)
println(numbersMap.mapKeys { it.key.uppercase() })
println(numbersMap.mapValues { it.value + it.key.length })
```

Zipping: create pairs of elements with the same position in both collections

```kotlin
val colors = listOf("red", "brown", "grey")
val animals = lisOf("fox", "bear", "wolf")
println(colors.zip(animals)) //result: [(red, fox), (brown, bear), (grey, wolf)]
//another form is by typing: colors zip animals
println(colors.zip(animals){ color, animal -> "The ${animal.replaceFirstChar { it.uppercase() }} is $color" })
```

Unzip:

```kotlin
val numberPairs = listOf("one" to 1, "two" to 2, "three" to 3)
println(numberPairs.unzip())
```

Association: build maps from the collection element and insert values associated with them.

```kotlin
val numbers = listOf("one", "two", "three")
println(numbers.associatedWith { it.length }) //result: {one=3, two=3, three=5}
println(numbers.associateBy { it.first().uppercase() }) //creates a key with the first letter of each element
//result: {O=one, T=three, F=four}
println(numbers.associateBy(keySelector = {it.first().uppercase()}, valuTransform = {it.length}))
//result: {O=3, T=5, F=4}, it transforms both keys and values.
```

associatedWith creates values and associateBy creates keys.

Flatten: convert a two dimensional array into a one dimensional array.

```kotlin
val numbersSets = ListOf(setOf(1,2,3), setOf(4,5,6), setOf(7,8,9))
val numbersFlatten = numbersSets.flatten()
```

# String representation

```kotlin
val numbersStrings = listOf("one", "two", "three")
val listString = StringBuffer("The list of numbers: ")
println(numbersString.joinTo(listString))
//result: The list of numbers: one, two, three
println(numbersString.joinToString(separator = " | ", prefix = "start: ", postfix = ": end"))

val numbers = (1..100).toList()
println(numbers.joinToString(limit = 5, truncated = "<...>"))
// result: 1, 2, 3, 4, 5, <...>

println(numbersString.joinToString { "Element: ${it.uppercase()}" })
//result: Element: ONE, Element: TWO, Element: TRHEE
```

# Filtering

filter retrieves the elements that match with a predicate.

```kotlin
val numbers = listOf("one", "two", "three")
val longerThan3 = numbers.filter { it.length > 3 }
println(longerThan3)
//result: three

val numbersMap = mapOf("key 1" to 1, "key 2" to 2, "key 3" to 3, "key 101" to 101)
val filteredMap = numbersMap.filter { it.key.endsWith("1") && it.value > 100 }
println(filteredMap)
//result: {key 101=101}

val filteredIndex = numbers.filterIndexed {index, value -> (index != 0) && (value.length < 5)}
val filteredNot = numbers.filterNot { it.length <= 3 }
println(filteredIndex)
//result: [two]
println(filteredNot)
//result: [three]

val mixedList = listOf(1,2,3,'A','B','C',"Hello world", false)
mixedList.filterIsInstance<Char>().forEach { println(it) } //filter by type
//result: A B C

//partition: keeps the elements that not match in a separate list
val (match, rest) = numbers.partition { it.length > 3 }
println(match)
//result: [three]
println(rest)
//result: [one, two]
```

# Test preifactes:

any(): returns true if one element matches the predicate

none(): returns true if all the elements does not match the predicate

all(): returns true if all the elements match the predicate

# Plus and minus operators

```kotlin
val numbers = mutableListOf("one", "two", "three")
val plusList = numbers + "four"
val minusList = numbers - mutableListOf("three", "two")
println(plusList)
// result: [one, two, three, four]
println(minusList)
//result: [one]
```

# Grouping

```kotlin
val numbers = listOf("one", "two", "three", "four", "five")
println(numbers.groupBy { it.first().uppercase() })
//result: {O=[one], T=[two, three], F=[four, five]}
println(numbers.groupBy(keySelector = {it.first()}, valueTransform = {it.uppercase()} ))
//result: {O=[ONE], T=[TWO, THREE], F=[FOUR, FIVE]}
```

# Retrieve Collections parts

```kotlin
val numbers = listOf("one", "two", "three", "four", "five", "six")
println(numbers.slice(1..3))
//result: [two, three, four]
println(numbers.slice(1..4 step 2))
//result: [one, three, five]
println(numbers.slice(setOf(3,5,0)))
//result: [four, six, one]

println(numbers.take(3))
//result: [one, two, three]
println(numbers.takeLast(3))
//result: [four, five, six]
println(numbers.drop(1))
//result: [two, three, four, five, six]
println(numbers.dropLast(5))
//result: [one]

println(numbers.takeWhile { !it.startsWith("f") }) //take elements until one element start with "f"
//result: [one, two, three]
println(numbers.takeLastWhile { !it != "three" })
//result: [four, five, six]
println(numbers.dropWhile { it.length == 3 })
//result: [three, four, five, six]
println(numbers.dropLastWhile { !it.contains("i") })
//result: [one, two, three, four]

val numbersInt = (0..13).toList()
println(numbersInt.chunked(3))
//result: [[0, 1, 2], [3, 4, 5], [6, 7, 8], [9, 10, 11], [12, 13]]
println(numbersInt.chunked(3, { it.sum() }))
//result: [3, 12, 21, 30, 25]

val numbersString2 = numbers
println(numbersString2.windowed(3))
//result: [[one, two, three], [two, three, four], [three, four, five], [four, five, six]]
```

# Retrieve single elements

```kotlin
val numbers = listOf("one", "two", "three", "four", "five")
println(numbers.elementAt(3))
//result: four
println(numbers.first())
//result: one
println(numbers.last())
//result: five
println(numbers.first{ it.length > 3 }) //retrieve first element with greater length than 3
//result: three
println(numbers.first{ it.startsWith("f")})
//result: five
println(numbers.random())
//result: RANDOM-ELEMENT
println(numbers.isEmpty())
//result: false
```

# Aggregate operations

```kotlin
val numbers = listOf(6,10,14,4,100)
println("The sum is ${numbers.sum()}")
println("The count is ${numbers.count()}")
println("The average is ${numbers.average()}")
println("The max value is ${numbers.maxOrNull()}")
println("The mean is ${numbers.meanOrNull()}")
println("The sum is ${numbers.sumOf { it * 2 } }") //multiplies the sum by 2
```

# Comparable and comparator

```kotlin
data class Laptop(val brand: String, val year: Int, val ram: Int, val price: Int)

val numbers = mutableListOf(2,5,1,40,20,100,60)
numbers.sorted().forEach { println(it) } //numbers sorted ascending
//It works because the Int class implements the compareTo function

//Comparator allows you to order by several fields
//you can do that by inheriting the Comparator in your comparator class and overriding the compare function
//for example if the comparator class is called ComparatorRam:
laptops.sortedWith(ComparatorRam().forEach { println(it) })

//Another option is using lambda functions
laptops.sortedWith(compareBy { it.price }).forEach { println(it) }
laptops.sortedWith(compareBy { it.ram }).forEach { println(it) }
laptops.sortBy { it.price }.forEach { println(it) } //shorter form than the previous one
laptops.sortBy { it.ram }.forEach { println(it) }
laptops.sortedWith(compareBy<Laptop> {it.year}. thenBy {it.price}).forEach { println(it) }
```

# Binary search

Binary search is a search algorithm used to find the position of a specific value within a sorted array or list. It works by repeatedly dividing the search interval in half. Here's how binary search works for finding the number 27 in a list of numbers from 1 to 30:

1. **Initialize**: Consider the entire list from 1 to 30.
2. **Find the middle element**: The middle element of the list is 15 (average of 1 and 30 rounded down).
3. **Compare**: Compare the middle element (15) with the target value (27).
    - Since 27 > 15, it means that if 27 exists in the list, it would be on the right half.
4. **New search interval**: Now, we narrow our search to the right half of the list, which is from 16 to 30.
5. **Find the new middle element**: The middle element of this new interval is 23.
6. **Compare**: Compare 23 with 27.
    - Since 27 > 23, again it means that 27 would be in the right half.
7. **New search interval**: Narrow our search to the interval from 24 to 30.
8. **Find the new middle element**: The middle element of this interval is 27.
9. **Compare**: Compare 27 with the target value (27).
    - Since they are equal, we have found the target value.

So, binary search successfully finds 27 in the list of numbers from 1 to 30.

The main advantage of binary search is that it's highly efficient, especially for large datasets, as it reduces the search space by half with each comparison, resulting in a time complexity of O(log n), where n is the number of elements in the list. However, it requires that the list be sorted initially.

```kotlin
numbers.binarySearch(27) //returns the index of the element with the value 27
```

For using binarySearch the elements must be sorted.