import { useAppTheme } from "@/hooks/useAppTheme";
import React from "react";
import { TouchableOpacity } from "react-native";

export default function CustomTouchableOpacity({
  backgroundPriority = "primary",
  children,
  styles,
  props,
}: {
  backgroundPriority?: "primary" | "secondary";
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
        borderRadius: theme.borderRadius.m,
        borderColor: theme.colors.borderColor,
        borderWidth: 1,
    }, styles]} {...props}>
      {children}
    </TouchableOpacity>
  );
}
