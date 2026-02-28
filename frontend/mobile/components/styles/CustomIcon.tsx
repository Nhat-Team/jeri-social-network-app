import { useAppTheme } from "@/hooks/useAppTheme";
import React from "react";

export default function CustomIcon({ icon, styles, props }:{ icon: React.ReactNode, styles?: object, props?: object }) {
    
    const theme = useAppTheme();
    
    return (
        <>
            {React.cloneElement(icon as React.ReactElement, {
                ...props,
                color: theme.colors.textColor
            })}
        </>
    )
}