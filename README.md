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