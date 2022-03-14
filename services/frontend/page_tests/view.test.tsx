import { screen } from "@testing-library/react";
import { getPage } from "next-page-tester";

test("Should show Title", async () => {
    const { render } = await getPage({
        route: "/view/banana",
    });

    render();
    expect(screen.queryByText("banana")).toBeVisible();
});