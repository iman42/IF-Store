import { render, screen, waitFor } from "@testing-library/react";
import Home from "../pages";


beforeEach(() => {
    fetchMock.mockResponseOnce(JSON.stringify(
        [
            { id: "ComicA-ID", title: "ComicA" },
            { id: "ComicB-ID", title: "ComicB" }
        ]
    ));
});

test("should show file upload button", async () => {
    await renderPage();
    expect(screen.queryByLabelText("Upload Comic")).toBeVisible();
});

test("should show hero", async () => {
    await renderPage();
    expect(screen.queryByText("IF Store")).toBeVisible();
});

test("comic buttons appear", async () => {
    await renderPage();
    expect(screen.queryByText("Uploaded Comics:")).toBeVisible();
});

test("Login button exists", async () => {
    await renderPage();
    expect(screen.queryByText("Login")).toBeVisible();
    expect(screen.queryByText("Signup")).toBeVisible();
});

async function renderPage() {
    render(<Home />);

    await waitFor(() => expect(screen.queryByText("Uploaded Comics:")).toBeVisible());
    await waitFor(() => expect(screen.queryByText("Loading...")).toBeNull());
}
