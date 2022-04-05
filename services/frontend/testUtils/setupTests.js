/* eslint-disable no-undef */
/* eslint-disable @typescript-eslint/no-var-requires */
import "@testing-library/jest-dom";

require("jest-fetch-mock").enableMocks();


const originalWindowLocation = window.location;
beforeEach(() => {
    Object.defineProperty(window, "location", {
        configurable: true,
        value: { reload: jest.fn() },
    });
});
afterEach(() => {
    Object.defineProperty(window, "location", { configurable: true, value: originalWindowLocation });
});
