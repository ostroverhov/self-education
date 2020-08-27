var firstArray = ["Alex", "Dima", "Kate", "Galina", "Ivan"]
var secondArray = ["Dima", "Ivan", "Kate"]

var difference = firstArray.filter(x => !secondArray.includes(x))

function getDifference(firstArr, secondArr){
    var resultArray = []
    for (let x = 0; x < firstArr.length; x++) {
        if (!secondArr.includes(firstArr[x])) {
            resultArray.push(firstArr[x])
        }
    }
    return resultArray
}

console.log(getDifference(firstArray, secondArray))
console.log(difference)