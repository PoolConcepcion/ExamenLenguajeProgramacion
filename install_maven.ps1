$url = "https://archive.apache.org/dist/maven/maven-3/3.9.9/binaries/apache-maven-3.9.9-bin.zip"
$zipFile = "$env:USERPROFILE\maven.zip"
$dest = "$env:USERPROFILE\maven"
Write-Host "Descargando Maven 3.9.9..."
Invoke-WebRequest -Uri $url -OutFile $zipFile
Write-Host "Extrayendo..."
Expand-Archive -Path $zipFile -DestinationPath $dest -Force
$mavenBin = "$dest\apache-maven-3.9.9\bin"
$userPath = [Environment]::GetEnvironmentVariable("PATH", "User")
if ($userPath -notlike "*$mavenBin*") {
    [Environment]::SetEnvironmentVariable("PATH", "$userPath;$mavenBin", "User")
    Write-Host "Maven agregado al PATH del usuario permanentemente."
}
$env:PATH = "$env:PATH;$mavenBin"
Write-Host "Maven instalado:"
mvn -version
