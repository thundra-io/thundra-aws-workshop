const TextAnalyzer = function (text, bannedWordList) {
    this.text = text;
    this.words = text.replace(/[^a-zA-Z0-9\s\-]/g, '').split(' ');
    this.bannedWords = bannedWordList;


    Array.prototype.pushSet = function (...items) { // convert array to linked-list-like set structure
        for (let item of items) {
            if (!this.includes(item)) {
                this[this.length] = item;
            }
        }
        return this.length;
    };

    this.getContent = function () {
        return this.text;
    }

    this.getTextLength = function () {
        return this.text.length;
    }

    this.getWordFrequency = function () {
        const wordCount = {}

        this.words.forEach(word => {

            if (wordCount[word])
                wordCount[word]++;
            else
                wordCount[word] = 1;
        });

        return wordCount;
    }

    this.getMostUsedWords = function () {
        const wordCount = this.getWordFrequency();
        const maxUsedWords = [];

        let maxUsedWordsCount = 0;

        for (let word in wordCount) {

            if (wordCount[word] > maxUsedWordsCount) {
                maxUsedWords.length = 0;
                maxUsedWordsCount = wordCount[word];
                maxUsedWords.pushSet(word);
            }
            else if (wordCount[word] === maxUsedWordsCount) {
                maxUsedWords.pushSet(word);
            }
        }

        return maxUsedWords;

    }

    this.getLeastUsedWords = function () {
        const wordCount = this.getWordFrequency();

        const minUsedWords = [];
        let minUsedWordsCount = Number.MAX_SAFE_INTEGER;

        for (let word in wordCount) {
            if (wordCount[word] < minUsedWordsCount) {

                minUsedWords.length = 0;
                minUsedWordsCount = wordCount[word];
                minUsedWords.pushSet(word);
            }
            else if (wordCount[word] === minUsedWordsCount) {
                minUsedWords.pushSet(word);
            }
        }
        return minUsedWords;
    }

    this.getBannedWords = function () {
        if (!this.getBannedWords)
            return [];

        const bannedWords = [];
        this.words.forEach(word => {
            if (this.bannedWords.includes(word))
                bannedWords.pushSet(word);

        });

        return bannedWords;
    }

    this.getMaxLengthWords = function () {
        const maxLengthWords = [];
        let maxLength = 0;

        this.words.forEach(word => {
            if (word.length > maxLength) {
                maxLengthWords.length = 0;
                maxLength = word.length;
                maxLengthWords.pushSet(word);
            }
            else if (word.length === maxLength) {
                maxLengthWords.pushSet(word);
            }

        });

        return maxLengthWords;
    }

    this.getMinLengthWords = function () {
        const minLengthWords = [];
        let minLength = Number.MAX_SAFE_INTEGER;

        this.words.forEach(word => {

            if (word.length < minLength) {
                minLengthWords.length = 0;

                minLength = word.length;
                minLengthWords.pushSet(word);
            }
            else if (word.length === minLength) {
                minLengthWords.pushSet(word);
            }
        });

        return minLengthWords;
    }

    this.toEntity = function () {
        return {
            content: this.getContent(),
            textLength: this.getTextLength() || 0,
            mostUsedWord: this.getMostUsedWords() || [],
            leastUsedWord: this.getLeastUsedWords() || [],
            bannedWord: this.getBannedWords() || [],
            maxLengthWord: this.getMaxLengthWords() || [],
            minLengthWord: this.getMinLengthWords() || []
        }
    }
}

module.exports = {
    TextAnalyzer
}
