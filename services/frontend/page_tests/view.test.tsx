import { screen } from "@testing-library/react";
import { getPage } from "next-page-tester";

test("Should show Title", async () => {
    const { render } = await getPage({
        route: "/view/banana",
    });

    render();
    expect(screen.queryByLabelText("comic-viewer")).toBeVisible();
    expect(screen.queryByLabelText("comic-viewer")).toHaveAttribute("data", "http://localhost:8080/comics/banana");
});