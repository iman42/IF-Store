import React, { ReactNode, useEffect, useRef, useState } from "react";
interface IProps {
    open?: boolean;
    header: string | React.ReactNode;
    headerClassName?: string;
    titleClassName?: string;
    iconButtonClassName?: string;
    contentClassName?: string;
    contentContainerClassName?: string;
    collapsibleClassName?: string;
    children?: ReactNode;
}

const Collapsible: React.FC<IProps> = ({
    open,
    collapsibleClassName = "collapsible-card-edonec",
    headerClassName = "collapsible-header-edonec",
    titleClassName = "title-text-edonec",
    iconButtonClassName = "collapsible-icon-button-edonec",
    contentClassName = "collapsible-content-edonec",
    contentContainerClassName = "collapsible-content-padding-edonec",
    children,
    header
}) => {
    const [isOpen, setIsOpen] = useState(open);
    const [height, setHeight] = useState<number | undefined>(
        open ? undefined : 0
    );
    const ref = useRef<HTMLDivElement>(null);
    const handleFilterOpening = () => {
        setIsOpen((prev) => !prev);
    };
    useEffect(() => {
        if (!height || !isOpen || !ref.current) return undefined;
        const resizeObserver = new ResizeObserver((el) => {
            setHeight(el[0].contentRect.height);
        });
        resizeObserver.observe(ref.current);
        return () => {
            resizeObserver.disconnect();
        };
    }, [height, isOpen]);
    useEffect(() => {
        if (isOpen) setHeight(ref.current?.getBoundingClientRect().height);
        else setHeight(0);
    }, [isOpen]);
    return (
        <>
            <button
                type="button"
                className={iconButtonClassName}
                onClick={handleFilterOpening}
            >
                <div className={collapsibleClassName}>
                    <div>
                        <div className={headerClassName}>
                            <div className={titleClassName}>{header}</div>

                        </div>
                    </div>
                    <div className={contentClassName} style={{ height }}>
                        <div ref={ref}>
                            <div className={contentContainerClassName}>{children}</div>
                        </div>
                    </div>
                </div>
            </button>
        </>
    );
};

export default Collapsible;
