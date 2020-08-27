const fs = require('fs');
var pathToFile = 'example.txt'
var defaultNumberStrings = 10

function selectStrings(pathToFile) {
    const readline = require('readline').createInterface({
        input: process.stdin,
        output: process.stdout
    })
    readline.question('Input number string for selection ', (answer) => {
    if (answer.length > 0) {
        workWithFiles(pathToFile, answer)
    } else {
        workWithFiles(pathToFile, defaultNumberStrings)
    }
    readline.close();
    })
}

function workWithFiles(pathToFile, numberSelectedStrings){
    let arrayStringsFromFile = fs.readFileSync(pathToFile, "utf8").split('\n');
    var arrayResultStrings = new Set()
    if (numberSelectedStrings <= arrayStringsFromFile.length) {
        while (arrayResultStrings.size < numberSelectedStrings) {
            var rand = Math.floor(Math.random() * arrayStringsFromFile.length)
            arrayResultStrings.add(arrayStringsFromFile[rand])
        }
    } else {
        console.error('Не достаточно строк')
    }
    var pathToNewFile = `${pathToFile.split('.')[0]}_res.${pathToFile.split('.')[1]}`
    fs.writeFileSync(pathToNewFile, [...arrayResultStrings].join('\n'))

    var arrayStringsFromFileAfterSelection = arrayStringsFromFile.filter(x => ![...arrayResultStrings].includes(x))
    fs.writeFileSync(pathToFile, [...arrayStringsFromFileAfterSelection].join('\n'))
    console.log(pathToNewFile)
}

selectStrings(pathToFile)