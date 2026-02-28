import { useAppTheme } from "@/hooks/useAppTheme";
import { TextInput } from "react-native";

export default function CustomTextInput({
  styles,
  props,
}: {
  styles?: object;
  props?: object;
}) {
  const theme = useAppTheme();

  return (
    <TextInput
      placeholderTextColor={theme.colors.textColor}
      style={[
        {
          size: theme.typography.body.fontSize,
          color: theme.colors.textColor,
          padding: theme.spacing.s,
          backgroundColor: theme.colors.surface,
          borderRadius: theme.borderRadius.m,
          borderColor: theme.colors.borderColor,
          borderWidth: 1,
          pointerEvents: "auto",
        },
        styles,
      ]}
      {...props}
    />
  );
}
