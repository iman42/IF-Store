module.exports = {
    testPathIgnorePatterns: ["<rootDir>/.next/", "<rootDir>/node_modules/"],
    setupFilesAfterEnv: ["<rootDir>/testUtils/setupTests.js"],
    transform: {
        "^.+\\.(js|jsx|ts|tsx)$": "<rootDir>/node_modules/babel-jest",
        "\\.(css|less|scss|sass)$": "<rootDir>/testUtils/styleMock.js",
    },
    testEnvironment: "jsdom",
};
