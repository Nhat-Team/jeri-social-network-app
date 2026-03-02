import { useAppTheme } from "@/hooks/useAppTheme";
import React from "react";
import { Text } from "react-native";

export default function CustomText({
  subtitle = false,
  content,
  children,
  styles,
  props,
}: {
  subtitle?: boolean;
  content?: string;
  children?: React.ReactNode;
  styles?: object;
  props?: object;
}) {
  const theme = useAppTheme();

  return (
    <Text
      style={[
        {
          color: theme.colors.textColor,
          fontSize: subtitle ? theme.typography.subtitle.fontSize : theme.typography.body.fontSize,
        },
        styles,
      ]}
      {...props}
    >
      {content || children}
    </Text>
  );
}
