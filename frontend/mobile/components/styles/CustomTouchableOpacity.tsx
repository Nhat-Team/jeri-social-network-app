import { useAppTheme } from "@/hooks/useAppTheme";
import React from "react";
import { TouchableOpacity } from "react-native";

export default function CustomTouchableOpacity({
  backgroundPriority = "primary",
  borderAllow = true,
  children,
  styles,
  props,
}: {
  backgroundPriority?: "primary" | "secondary";
  borderAllow?: boolean;
  children?: React.ReactNode;
  styles?: object;
  props?: object;
}) {
  const theme = useAppTheme();

  return (
    <TouchableOpacity style={[{
        backgroundColor: backgroundPriority === "primary" ? theme.colors.backgroundPrimary : theme.colors.backgroundSecondary,
        padding: theme.spacing.s,
        color: theme.colors.textColor,
        borderRadius: borderAllow ? theme.borderRadius.m : 0,
        borderColor: borderAllow ? theme.colors.borderColor : "transparent",
        borderWidth: borderAllow ? 1 : 0,
    }, styles]} {...props}>
      {children}
    </TouchableOpacity>
  );
}
