package ni.edu.uam.app_recarga

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ni.edu.uam.app_recarga.ui.theme.App_RecargaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App_RecargaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(
                        modifier = Modifier.padding(innerPadding),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        RechargeScreen()
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RechargeScreen() {
    var phoneNumber by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    var selectedCompany by remember { mutableStateOf("") }
    var showResult by remember { mutableStateOf(false) }
    var attemptRegistration by remember { mutableStateOf(false) }

    val companies = listOf("Claro", "Tigo")
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Mis Recargas",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.ExtraBold
        )

        Text(
            text = "Gestión de recargas telefónicas para tu equipo.",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { 
                phoneNumber = it
                if (it.isNotBlank()) attemptRegistration = false 
            },
            label = { Text("Número de Teléfono") },
            placeholder = { Text("0000 0000") },
            leadingIcon = { Icon(Icons.Default.Phone, contentDescription = null) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            isError = attemptRegistration && phoneNumber.isBlank(),
            singleLine = true,
            shape = MaterialTheme.shapes.medium,
            supportingText = {
                if (attemptRegistration && phoneNumber.isBlank()) {
                    Text("El número es obligatorio", color = MaterialTheme.colorScheme.error)
                }
            }
        )

        OutlinedTextField(
            value = amount,
            onValueChange = { 
                amount = it
                if (it.isNotBlank()) attemptRegistration = false
            },
            label = { Text("Monto de la Recarga") },
            leadingIcon = { Icon(Icons.Default.ShoppingCart, contentDescription = null) },
            prefix = { Text("C$ ", fontWeight = FontWeight.Bold) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            isError = attemptRegistration && amount.isBlank(),
            singleLine = true,
            shape = MaterialTheme.shapes.medium,
            supportingText = {
                if (attemptRegistration && amount.isBlank()) {
                    Text("Ingrese un monto válido", color = MaterialTheme.colorScheme.error)
                }
            }
        )

        var expanded by remember { mutableStateOf(false) }
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded },
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = selectedCompany,
                onValueChange = {},
                readOnly = true,
                label = { Text("Compañía") },
                leadingIcon = { Icon(Icons.Default.Build, contentDescription = null) },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor().fillMaxWidth(),
                isError = attemptRegistration && selectedCompany.isBlank(),
                shape = MaterialTheme.shapes.medium,
                colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                companies.forEach { company ->
                    DropdownMenuItem(
                        text = { Text(company) },
                        onClick = {
                            selectedCompany = company
                            expanded = false
                            attemptRegistration = false
                        }
                    )
                }
            }
        }

        Button(
            onClick = {
                attemptRegistration = true
                if (phoneNumber.isNotBlank() && amount.isNotBlank() && selectedCompany.isNotBlank()) {
                    showResult = true
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .height(56.dp),
            shape = MaterialTheme.shapes.medium
        ) {
            Icon(Icons.AutoMirrored.Filled.Send, contentDescription = null)
            Spacer(Modifier.width(8.dp))
            Text("Registrar Recarga", style = MaterialTheme.typography.titleMedium)
        }

        AnimatedVisibility(
            visible = showResult,
            enter = fadeIn() + expandVertically(),
            exit = fadeOut() + shrinkVertically()
        ) {
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                shape = MaterialTheme.shapes.extraLarge,
                colors = CardDefaults.elevatedCardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(56.dp)
                    )
                    
                    Text(
                        text = "¡Registro Exitoso!",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold
                    )
                    
                    HorizontalDivider(
                        color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.2f)
                    )
                    
                    InfoRow(icon = Icons.Default.Phone, label = "Destino", value = phoneNumber)
                    InfoRow(icon = Icons.Default.Add, label = "Total", value = "C$ $amount")
                    InfoRow(icon = Icons.Default.Star, label = "Operador", value = selectedCompany)
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    FilledTonalButton(
                        onClick = {
                            phoneNumber = ""
                            amount = ""
                            selectedCompany = ""
                            showResult = false
                            attemptRegistration = false
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(Icons.Default.Refresh, contentDescription = null)
                        Spacer(Modifier.width(8.dp))
                        Text("Nueva Recarga")
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Composable
fun InfoRow(icon: ImageVector, label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                tint = MaterialTheme.colorScheme.primary
            )
            Spacer(Modifier.width(12.dp))
            Text(
                text = label,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f)
            )
        }
        Text(
            text = value,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RechargeScreenPreview() {
    App_RecargaTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            RechargeScreen()
        }
    }
}
