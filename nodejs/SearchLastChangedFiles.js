var timeRange = 10000
var extension = 'txt'
var directoryName = './'
const fs = require('fs');
const path = require('path');

function getLastModifiedFiles(timeRange, extension, directoryName) {
    var files = []

    fs.readdirSync(directoryName).forEach(file => {
        if (path.extname(file).includes(extension)) {
            files.push(file)
        }
    });

    files.sort(function (a, b) {
        return fs.statSync(b).ctimeMs - fs.statSync(a).ctimeMs
    })

    let latestFile = files[0]
    files.forEach(file => {
        if (fs.statSync(file).ctimeMs + timeRange >= fs.statSync(latestFile).ctimeMs) {
            console.log(file)
        }
    })
}

getLastModifiedFiles(timeRange, extension, directoryName)