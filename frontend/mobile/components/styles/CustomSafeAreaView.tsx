import { useAppTheme } from "@/hooks/useAppTheme";
import { SafeAreaView } from "react-native-safe-area-context";

export default function CustomSafeAreaView({
  children,
  backgroundPriority,
  styles,
  props,
}: {
  children?: React.ReactNode;
  backgroundPriority?: "primary" | "secondary";
  styles?: object;
  props?: object;
}) {
  const theme = useAppTheme();

  return (
    <SafeAreaView
      style={[
        {
          backgroundColor: backgroundPriority === "secondary" ? theme.colors.backgroundSecondary : theme.colors.backgroundPrimary,
          padding: theme.spacing.m,
          pointerEvents: "auto",
          height: "100%",
        },
        styles,
      ]}
      {...props}
    >
      {children}
    </SafeAreaView>
  );
}
